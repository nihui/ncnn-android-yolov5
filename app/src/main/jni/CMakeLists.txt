project(yolov5ncnn)

cmake_minimum_required(VERSION 3.4.1)

# import ncnn library
add_library(ncnn STATIC IMPORTED)
# change this folder path to yours
set_target_properties(ncnn PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/ncnn-android-vulkan-lib/${ANDROID_ABI}/libncnn.a)
include_directories(${CMAKE_SOURCE_DIR}/ncnn-android-vulkan-lib/include/ncnn)

add_library(glslang STATIC IMPORTED)
add_library(OGLCompiler STATIC IMPORTED)
add_library(OSDependent STATIC IMPORTED)
add_library(SPIRV STATIC IMPORTED)
set_target_properties(glslang PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/ncnn-android-vulkan-lib/${ANDROID_ABI}/libglslang.a)
set_target_properties(OGLCompiler PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/ncnn-android-vulkan-lib/${ANDROID_ABI}/libOGLCompiler.a)
set_target_properties(OSDependent PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/ncnn-android-vulkan-lib/${ANDROID_ABI}/libOSDependent.a)
set_target_properties(SPIRV PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/ncnn-android-vulkan-lib/${ANDROID_ABI}/libSPIRV.a)

# openmp
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -fopenmp")
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fopenmp")
set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} -fopenmp")

if(DEFINED ANDROID_NDK_MAJOR AND ${ANDROID_NDK_MAJOR} GREATER 20)
    set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} -static-openmp")
endif()

set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -fomit-frame-pointer -fstrict-aliasing -ffast-math")
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fomit-frame-pointer -fstrict-aliasing -ffast-math")

set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -fvisibility=hidden")
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fvisibility=hidden -fvisibility-inlines-hidden")

# disable rtti and exceptions
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fno-rtti -fno-exceptions")

add_library(yolov5ncnn SHARED yolov5ncnn_jni.cpp)

target_link_libraries(yolov5ncnn
    ncnn

    glslang SPIRV OGLCompiler OSDependent

    android
    z
    log
    jnigraphics
    vulkan
)
