LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

# ��� ������ ������, ������� ����� ���������� � Java ��� ������ System.loadLibrary()
LOCAL_MODULE    := SolvingEquation
 
 LOCAL_CFLAGS := -DSOLVINGEQUATION  -Wno-psabi -DGL_GLEXT_PROTOTYPES=1 -std=c++11 -pthread -frtti
 
LOCAL_DEFAULT_CPP_EXTENSION := cpp
 
#�������� ��������� ���������� � �������� ����
LOCAL_CPP_FEATURES += exceptions

#������ ������, ������� ����� �������
LOCAL_SRC_FILES := Solving.cpp
 
#������ ��������� �� ndk, ������� ���� �������� � ������
LOCAL_LDLIBS :=  -llog -landroid

include $(BUILD_SHARED_LIBRARY)

