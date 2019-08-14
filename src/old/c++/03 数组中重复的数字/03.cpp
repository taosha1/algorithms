// ConsoleApplication2.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。

#include <iostream>

using namespace std;

bool func1(int arr[], int length,int* p) {
	if (arr == nullptr || length <= 0) {
		return false;
	}
	for (int i = 0; i < length; i++)
	{
		if (arr[i] < 0||arr[i]>length-1) {
			return false;
		}
	}

	for (int i = 0; i < length;)
	{
		if (i == arr[i]) {
			i++;
		}
		else {
			if (arr[arr[i]]==arr[i])
			{
				*p = arr[i];
				return true;
			}
			else {
				int temp = arr[i];
				arr[i] = arr[arr[i]];
				arr[temp] = temp;
			}
		}
	}
	return false;
}


void test1() {
	int numbers[] = { 2, 1, 3, 1, 4 };
	int* ptr = new int;
	cout << func1(numbers, sizeof(numbers) / sizeof(*numbers), ptr) << endl;
	cout << *ptr;
}
void test2() {
	int numbers[] = { 2, 4, 3, 1, 4 };
	int* ptr = new int;
	cout << func1(numbers, sizeof(numbers) / sizeof(*numbers), ptr) << endl;
	cout << *ptr;
}
void test3() {
	int numbers[] = { 2, 1, 3, 5, 4 };
	int* ptr = new int;
	cout << func1(numbers, sizeof(numbers) / sizeof(*numbers), ptr) << endl;
	cout << *ptr;
}

int main() {
	//test1();
	//test2();
	test3();
	return 0;
}
