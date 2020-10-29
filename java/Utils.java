
class Utils {

    public void util() {
        // 字符串与整型的相互转换
        String str = String.valueOf(2);
        int i = Integer.parseInt(str);

        // 获取当前方法的名字
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        // 字符串转日期
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(str);
    }

}