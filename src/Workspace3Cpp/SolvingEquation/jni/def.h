#include <android/log.h>
#include <cmath>
#include <string>
#include <sstream>
//#include <iostream>

#ifdef __ANDROID__
#define LOG_TAG "Solving"
#define STRINGIFY(x) #x
#define LOG_TAG    __FILE__ ":" STRINGIFY(__Solving__)
#define LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

#endif
