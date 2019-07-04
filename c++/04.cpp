#include<iostream>
#include<cstdio>
using namespace std;

bool funtion4(const int* arr,int row,int column,int num){
    bool flag = false;
    if(arr!=NULL && row > 0 && column > 0){

        int tempRow = 0;
        int tempColnum = column-1;
        while(tempRow < row && tempColnum >= 0){
            if(arr[tempRow*column+tempColnum]==num){
                return true;
            }else if(arr[tempRow*column+tempColnum]<num){
                tempRow++;
            }else{
                tempColnum--;
            }
        }
    }
    return flag;

}
void Test(char* testName, int* matrix, int rows, int columns, int number, bool expected)
{
    if(testName != NULL)
        printf("%s begins: ", testName);

    bool result = funtion4(matrix, rows, columns, number);
    if(result == expected)
        printf("Passed.\n");
    else
        printf("Failed.\n");
}

//  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数在数组中
void Test1()
{
    int matrix[][4] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
    Test("Test1", (int*)matrix, 4, 4, 7, true);
}
int main(){
    Test1();
    return 0;
}
