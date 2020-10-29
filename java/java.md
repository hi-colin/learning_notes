### Java 基础语法学习笔记

#### final：  
* 内部类访问的局部变量，需要final修饰：  
* 根本原因是内容类对象无法访问局部变量，才会去复制一份。为了保证两个变量的一致性，  
* 才会去使用final关键字修饰局部变量。而不是因为栈生命周期与堆生命周期不一致的问题。  
  
#### & 和 &&、| 和 || 的区别：  
* 区别 1： & 和 | 可以进行位运算，后者不能。  
* 区别 2： && 和 || 进行运算时有短路性，前者无。  

#### protected：  
关于protected修饰符分享一点自己总结的规律：  
* 遇到调用protected修饰的方法，沿着继承关系向上寻找此方法的最后一次实现是否和当前调用的地方处于同一个包内，
如果是，那么可以调用，如果不是，那么不行。但有一种情况例外，如果向上寻找实现的时候路过了当前调用的地方所处的类，
那么这种情况下即使本类没有实现这个方法，那也是可以编译通过的。
* 其实对于protected的理解通俗点讲就是，这个方法，只有你跟我在一起（同一个包）的时候才给你用，你不跟我在一起我就不给你用了。
    
#### static与volatile：  
* static指的是类的静态成员，实例间共享  
* volatile跟Java的内存模型有关，线程执行时会将变量从主内存加载到线程工作内存，建立一个副本，在某个时刻写回。
* valatile指的每次都读取主内存的值，有更新则立即写回主内存

#### 特殊的switch case：  
```Java
public class Test {
   public static void main(String args[]){
      int i = 1;
      switch(i){
         case 0:
            System.out.println("0");
         case 1:
            System.out.println("1");
         case 2:
            System.out.println("2");
         case 3:
            System.out.println("3"); break;
         default:
            System.out.println("default");
      }
   }
}
```

#### == 与 equals的区别  
* == 它比较的是对象的地址
* equals 比较的是对象的内容

* 非 new 生成的 Integer 变量指向的是 java 常量池中的对象，
* 而 new Integer() 生成的变量指向堆中新建的对象，两者在内存中的地址不同。

* 包装类 Integer 变量在与基本数据类型 int 变量比较时，（==）
* Integer 会自动拆包装为 int，然后进行比较，实际上就是两个 int 变量进行比较，值相等，就为 true。

#### String类常见面试题
```java
String s1 = "abc";            // 常量池
String s2 = new String("abc");     // 堆内存中
System.out.println(s1==s2);        // false两个对象的地址值不一样。
System.out.println(s1.equals(s2)); // true

String s1="a"+"b"+"c";
String s2="abc";
System.out.println(s1==s2);     // true
System.out.println(s1.equals(s2));      // true

String s1="ab";
String s2="abc";
String s3=s1+"c";
System.out.println(s3==s2);         // false
System.out.println(s3.equals(s2));  // true
```

#### String基本原则：  
* 如果要操作少量的数据用 String；  
* 单线程操作大量数据用StringBuilder；  
* 多线程操作大量数据，用StringBuffer。  

#### 方法的重载
* 重载的方法必须拥有不同的参数列表。你不能仅仅依据修饰符或者返回类型的不同来重载方法。

#### 文件流
* 一个流可以理解为一个数据的序列。输入流表示从一个源读取数据，输出流表示向一个目标写数据。

#### 三种类型的异常：
* 检查性异常：最具代表的检查性异常是用户错误或问题引起的异常，这是程序员无法预见的。例如要打开一个不存在文件时，一个异常就发生了，这些异常在编译时不能被简单地忽略。
* 运行时异常： 运行时异常是可能被程序员避免的异常。与检查性异常相反，运行时异常可以在编译时被忽略。比如数组越界、访问null对象。
* 错误： 错误不是异常，而是脱离程序员控制的问题。错误在代码中通常被忽略。例如，当栈溢出时，一个错误就发生了，它们在编译也检查不到的。

#### 在Java中定义了两种类型的异常和错误。
* JVM(Java虚拟机) 异常：由 JVM 抛出的异常或错误。例如：NullPointerException 类，ArrayIndexOutOfBoundsException 类，ClassCastException 类。
* 程序级异常：由程序或者API程序抛出的异常。例如 IllegalArgumentException 类，IllegalStateException 类。
> 异常和错误的区别：异常能被程序本身可以处理，错误是无法处理。

#### 异常代码示例
```java
try{
   //待捕获代码    
}catch（Exception e）{
    System.out.println("catch is begin");
    return 1 ；
}finally{
     System.out.println("finally is begin");
     return 2 ;
}
```
 执行了finally后已经return了，所以catch里面的return不会被执行到。也就是说finally永远都会在catch的return前被执行。
> finally不一定被执行情况，例如 catch 块中有退出系统的语句 System.exit(-1); finally就不会被执行

#### 方法的重新和重载
* 重写是子类对父类的允许访问的方法的实现过程进行重新编写, 返回值和形参都不能改变。即外壳不变，核心重写！  
* 重载是在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同。

> 关键词理解： 父类的引用指向子类的实例（转型）（在向下转型之前，它得先向上转型）   
> 向上转型后，方法调用： 编译时，编译器使用父类的方法验证语句，但是运行时，Java虚拟机（JVM）调用的是子类方法。

#### 多态
* 继承链中对象方法的调用的优先级：this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)。
* 在向上引用时，子类的同名非静态成员方法与成员变量会覆盖父类的同名非静态成员方法和成员变量，子类的同名静态成员方法
会被父类的同名静态成员方法隐藏，也就是说被覆盖。  

#### 抽象类
* 构造方法，类方法（用 static 修饰的方法）不能声明为抽象方法
* 驱动函数： 即main函数
* 并不是说"一定要调用父类的显性构造器"，而是子类在继承父类时，如果父类的显式构造器中有参数，子类要声明给出这个参数。
* 继承是一个 "是不是"的关系，而 接口实现则是 "有没有"的关系。
* 如果一个非抽象类遵循了某个接口，就必须实现该接口中的所有方法。对于遵循某个接口的抽象类，可以不实现该接口中的抽象方法。
* 封装： private属性，提供getter和setter方法。

#### 接口
* 接口可以继承接口，并且可以多继承
* 接口类型可用来声明一个变量： 类可以实现接口，再向上转型（绑定在一个以此接口实现的对象）

#### 多态的成员特点
* 成员变量  编译时看的是左边，运行时看的左边
* 成员方法  编译时看的是左边，运行时看右边
* 静态方法  编译时看的是左边，运行时看的也是左边

> 一个已经向上转型的子类对象可以使用强制类型转换的格式，将父类引用转为子类引用，这个过程是向下转型。
如果是直接创建父类对象，是无法向下转型的
> 打包编译： Java 命令的参数是"类的完整类名"，而不是"文件名"。

#### Lambda使用条件
* 必须有接口（不能是抽象类），接口中有且仅有一个需要被重写的抽象方法。
* 必须支持上下文推导，要能够推导出来 Lambda 表达式表示的是哪个接口中的内容。
> 可以使用接口当做参数，然后传递 Lambda 表达式(常用)，也可以将 Lambda 表达式赋值给一个接口类型的变量。