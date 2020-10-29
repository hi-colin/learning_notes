#include <stdio.h>

int main() {
    printf("Hello World!\n");
    return 0;
}

/*
#include <stdlib.h>

int main() {
//    FILE *fp;
//    if ((fp = fopen("test.dat", "wb")) == NULL) {
//        printf("cannot open file\n");
//        exit(0);
//    }

    char name[] = "Hello World!";
//    fwrite(name, sizeof(name), 1, fp);

    FILE *fp;
    if ((fp = fopen("test.dat", "rb")) == NULL) {
        printf("cannot open file\n");
        exit(0);
    }

    char str[20];
    while (!feof(fp)) {
        fread(str, sizeof(name), 1, fp);
    }
    printf("%s", str);

    return 0;
}
*/


// 文件读写(结构体)
/*#include <stdlib.h>

#define SIZE 10

struct Student_type {
    char name[10];
    int num;
    int age;
    char addr[15];
} stud[SIZE];

void save() {
    FILE *fp;
    int i;
    if ((fp = fopen("stu.dat", "wb")) == NULL) {
        printf("cannot open file\n");
        return;
    }
    for(i = 0; i < SIZE; i++) {
        if (fwrite(&stud[i], sizeof(struct Student_type), 1, fp) != 1) {
            printf("file write error\n");
        }
    }
    fclose(fp);
}

int main() {
//    printf("please enter data of student: \n");
//    for (int i = 0; i < SIZE; ++i) {
//        scanf("%s%d%d%s", stud[i].name, &stud[i].num, &stud[i].age, stud[i].addr);
//    }
//    save();
//    return 0;

//    FILE *fp;
//    if ((fp = fopen("stu.dat", "rb")) == NULL) {
//        printf("cannot open file\n");
//        exit(0);
//    }
//    for (int i = 0; i < SIZE; ++i) {
//        fwrite(&stud[i], sizeof(struct Student_type), 1, fp);
//        printf("%10s %4d %4d %15s\n", stud[i].name, stud[i].num, stud[i].age, stud[i].addr);
//    }
//    fclose(fp);
//    return 0;

}*/


/*#include <malloc.h>

#define LEN sizeof(struct Student)

struct Student {
    long num;
    float score;
    struct Student *next;
};

int n;

// 链表
void main() {
    struct Student *creat();
    void print(struct Student *head);

    struct Student *head;

    head = creat();
    print(head);
}


struct Student *creat() {
    struct Student *head;
    struct Student *p1, *p2;

    n = 0;

    p1 = p2 = malloc(LEN);
    scanf("%ld, %f", &p1->num, &p1->score);

    head = NULL;
    while(p1->num != 0) {
        n = n +1;
        if (n == 1) {
            head = p1;
        } else {
            p2->next = p1;
        }
        p2 = p1;

        p1 = malloc(LEN);
        scanf("%ld, %f", &p1->num, &p1->score);
    }
    p2->next = NULL;
    return head;
}

void print(struct Student *head) {
    struct Student *p;
    p = head;

    printf("\nNow, There %d record are: \n", n);

    if (head != NULL) {
        while (p != NULL) {
            printf("%ld, %lf\n", p->num, p->score);
            p = p->next;
        }
    }
}*/


/*int main() {
    float *search(float (*pointer)[4]);
    float score[][4] = {{60, 70, 80, 90},
                        {23, 45, 56, 67},
                        {23, 56, 78, 34}};
    float *p;
    int i, j;
    for (i = 0; i < 3; i++) {
        p = search(score + i);

        if (p == *(score + i)) {
            printf("No. %d score:", i);
            for (j = 0; j < 4; ++j) {
                printf("%5.2f ", *(p + j));
            }
            printf("\n");
        }
    }
    return 0;
}

float *search(float (*pointer)[4]) {
    int i = 0;
    float *pt;
    pt = NULL;
    for (; i < 4; ++i) {
        if (*(*pointer + i) < 60) {
            pt = *pointer;
        }
    }
    return pt;
}*/


/*int main() {
    void print(char *name[], int n); // 函数声明

    char *name[] = {"23434", "I Love China"};
    print(name, 2);
    return 0;
}

void print(char *name[], int n) {
    int i = 0;
    char *p;
    while (i < n) {
        p = *(name + i++);
        printf("%s\n", p);
    }
}*/

/*int main() {
    char a[] = "I Love China";
    char * p = "I Love China"; // 字符串常量，不能赋值

    a[5] = 'c';
    printf("%c", *(p+5));
    printf("%c", p[5]);
}*/

/*int main() {
    int a[] = {1, 3, 5};
    int * p = a;
    printf_s("%d\n", * ++p);
    return 0;
}*/

// 冒泡排序
/*int main() {
    int a[10];

    printf("%s\n", "please input 10 integer:");
    for (int i = 0; i <= 9; i++) {
        scanf("%d", &a[i]);
    }

    for (int j = 0; j < 9; ++j) {
        for (int i = 0; i < 9 - j; ++i) {
            if (a[i] > a[i + 1]) {
                int t = a[i];
                a[i] = a[i + 1];
                a[i + 1] = t;
            }
        }
    }

    for (int l = 0; l <= 9; ++l) {
        printf("%d\t", a[l]);
    }

    return 0;
};*/

// 选择排序
/*int main() {
    int a[5] = {5, 3, 7, 8, 2};

    for (int i = 0; i < 4; ++i) {
        int k = i;
        for (int j = i; j < 5; ++j) {
            if (a[i] > a[j]) {
                k = j;
            }
        }
        if (k != i) {
            int t = a[i];
            a[i] = a[k];
            a[k] = t;
        }
    }

    for (int k = 0; k < 5; ++k) {
        printf("%d\t", a[k]);
    }

    return 0;
}*/
