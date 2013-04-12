
#include <jni.h>
#include "fact.h"

double Java_com_techtest_nativefactorial_MainActivity_calculateFactorial(
    JNIEnv * env, jobject this, int val)
{
    if(val == 0) {
    	return 0;
    }

    double result = 1;
    for(int i = 2; i<=val; ++i) {
        result *= i;
    }

    return result;
}
