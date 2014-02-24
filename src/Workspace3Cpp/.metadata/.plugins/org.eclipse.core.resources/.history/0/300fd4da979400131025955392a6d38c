#include <Solving.h>

template <typename T>
void TypeToStr(const T &rhs, char *tmp, char* type = "%f")
{
	sprintf(tmp, type, rhs);
}

void Clear()
{
	memset(MyStr, '\0', LEN);
}

void MakeOneAnswer(double x)
{
	char tmp[LEN] = { '\0' };
	TypeToStr<double>(x, tmp);
	strcat(MyStr, tmp);
	//memcpy(MyStr, tmp, LEN);
}

void MakeOneAnswer(char* tmp)
{
	strcat(MyStr, tmp);
}

void MakeTwoAnswers(double x1, double x2)
{
	const int L = (LEN/2) - 1;
	char tmp1[L] = { '\0' };
	char tmp2[L] = { '\0' };

	TypeToStr<double>(x1, tmp1);
	TypeToStr<double>(x2, tmp2);

	char tmp[LEN] = { '\0' };

	strcat(MyStr, tmp1);
	strcat(MyStr, "   ");
	strcat(MyStr, tmp2);
}

JNIEXPORT jstring Java_test_example_solvingequation_SolvingEquation_Solving(JNIEnv * env, jobject obj, jdouble a, jdouble b, jdouble c)
{
	//TODO: Use one function to set MyStr
	//TODO: if b % 2 == 0

	LOGI("Start GetData");

	Clear();
	double x1 = 0.0, x2 = 0.0;
	double det = 0.0;

	if(a == 0 && b == 0)
		MakeOneAnswer("Not a valid equation. Its not a quadratic equation");

	if(a == 0 && b != 0)
	{
		x1 = -(c / b);
		MakeOneAnswer(x1);
	}

	det = b * b - 4 * a * c;
	if (det >= 0)
	{
		if(det == 0)
		{
			x1 = -(b / (2 * a));
			MakeOneAnswer(x1);
		}
		else
		{
			x1 = (-b + sqrt(det)) / (2 * a);
			x2 = (-b - sqrt(det)) / (2 * a);
			MakeTwoAnswers(x1, x2);
		}
	}
	if (det < 0)
		MakeOneAnswer("Not a real root");

	LOGI("End GetData");

	return env->NewStringUTF(MyStr);
}
