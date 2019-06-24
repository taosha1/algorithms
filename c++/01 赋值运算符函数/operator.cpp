#include<iostream>
#include<cstring>
#include<cstdio>

class CMyString
{
public:
    CMyString(char* pData = nullptr);
    CMyString(const CMyString& str);
    ~CMyString(void);

    CMyString& operator=(const CMyString& myString);
private:
    char* m_pData;
};

CMyString::CMyString(char* pData){
    if(pData==NULL){
        m_pData = new char[1];
        m_pData[0] = '0';
    }
    else{
        m_pData = new char [strlen(pData)+1];
        strcpy(m_pData,pData);
    }
}

CMyString::CMyString(const CMyString& str){
    m_pData = new char[strlen(str.m_pData)+1];
    strcpy(m_pData,str.m_pData);
}

CMyString::~CMyString(){
    delete[]m_pData;
}

CMyString& CMyString::operator=(const CMyString& myString){
    if(this == &myString){
        return *this;
    }
    delete[] m_pData;
    m_pData = NULL;
    m_pData = new char[strlen(*myString.m_pData)+1];
    strcpy(this->m_pData,myString.m_pData);
    return *this;
}

void test1() {

	printf("Test1 begins:\n");

	const char* text = "Hello world";

	CMyString str1(text);
	CMyString str2;
	str2 = str1;

	printf("The expected result is: %s.\n", text);

	printf("The actual result is: ");
	str2.Print();
	printf(".\n");
}


// 赋值给自己
void test2()
{
	printf("Test2 begins:\n");

	const char* text = "Hello world";

	CMyString str1(text);
	str1 = str1;

	printf("The expected result is: %s.\n", text);

	printf("The actual result is: ");
	str1.Print();
	printf(".\n");
}

// 连续赋值
void test3()
{
	printf("Test3 begins:\n");

	const char* text = "Hello world";

	CMyString str1(text);
	CMyString str2, str3;
	str3 = str2 = str1;

	printf("The expected result is: %s.\n", text);

	printf("The actual result is: ");
	str2.Print();
	printf(".\n");

	printf("The expected result is: %s.\n", text);

	printf("The actual result is: ");
	str3.Print();
	printf(".\n");
}
int main() {

	//test1();
	//test2();
	//test3();
	return 0;
}
