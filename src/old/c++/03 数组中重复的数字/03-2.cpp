#include<iostream>

using namespace std;

int findCount(const int arr[],int length,int start,int end);

int funtion3(const int arr[],int length){

    if(arr == NULL || length <= 0){
        return -1;
    }

    int start = 1;
    int end = length - 1;

    while(end>=start){
        int mid = ((end-start)>>1)+start;
        int count = findCount(arr,length,start,mid);
        if(end == start){
            if(count>1){
                return start;
            }else{
                break;
            }
        }
        if(count>(mid - start +1)){
            end = mid;
        }else{
            start = mid + 1;
        }
    }
    return -1;
}
int findCount(const int arr[],int length,int start,int end){
    if(arr==NULL || length <= 0){
        return 0;
    }

    int count = 0;
    for(int i=0;i<length;i++){
        if(arr[i]>=start && arr[i]<=end){
            count++;
        }
    }
    return count;
}
int main(){

    int numbers[] = { 2, 3, 5, 4, 3, 2, 6, 7 };
    int length = sizeof(numbers)/sizeof(*numbers);
    cout<<funtion3(numbers,length);

    return 0;
}
