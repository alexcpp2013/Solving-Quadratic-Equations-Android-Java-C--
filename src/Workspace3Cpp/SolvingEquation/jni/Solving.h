/*
 * Solving.h
 *
 *  Created on: 12.02.2014
 *      Author: a_melnik
 */

#ifndef SOLVING_H_
#define SOLVING_H_

#include <def.h>
#include <jni.h>

//std::string MyStr;

extern "C" {
	JNIEXPORT jstring Java_test_example_solvingequation_SolvingEquation_Solving(JNIEnv * env, jobject obj, jdouble a, jdouble b, jdouble c);
}


#endif /* SOLVING_H_ */
