LOCAL_PATH := $(call my-dir)  

include $(CLEAR_VARS)

LOCAL_CFLAGS   = -Wall -pedantic -std=c99 -g
LOCAL_LDLIBS := -llog  
LOCAL_MODULE    := factlib

LOCAL_SRC_FILES := fact.c  

include $(BUILD_SHARED_LIBRARY)