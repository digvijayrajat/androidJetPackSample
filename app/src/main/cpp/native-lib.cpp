
#include <jni.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_stride_sportsconnect_view_activity_BaseActivity_getApiKey(
        JNIEnv* pEnv,
        jclass jclazz) {
    return pEnv->NewStringUTF("Your_API_KEY");
}