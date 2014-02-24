#include <Solving.h>

template <typename T>
auto TypeToStr(const T& value, char* type = "%f") -> std::string
{
	//TODO: &&

	const int LEN = 50;
	char s[LEN] = { '\0' };

	sprintf(s, type, value);
	std::string tmp(s);// = (const char*) s;
	return tmp;

	/*std::ostringstream oss;

	try
	{
		oss << value;
	}
	catch(...)
	{
		;
	}
	return oss.str();*/
}

auto MakeClear = [](std::string& str)
{
	//std::copy(str.begin(), str.end(), "");
	str = "";
};

inline auto Clear(std::string& str) -> void
{
	str = "";
	//MyStr("");
}

inline auto MakeAnswer(std::string& str, double x) -> void
{
	str = TypeToStr<double>(x);
}

inline auto MakeAnswer(std::string& str, const std::string& tmp) -> void
{
	str = tmp;
}

inline auto MakeAnswer(std::string& str, double x1, double x2) -> void
{
	str = TypeToStr<double>(x1) + "   " + TypeToStr<double>(x2);
}

JNIEXPORT jstring Java_test_example_solvingequation_SolvingEquation_Solving(JNIEnv * env, jobject obj, jdouble a, jdouble b, jdouble c)
{
	//TODO: Use one function to set MyStr
	//TODO: if b % 2 == 0

	LOGI("Start GetData");

	std::string MyStr = "";
	MakeClear(MyStr);

	auto x1 = 0.0;
	auto x2 = 0.0;
	auto det = 0.0;

	if(a == 0 && b == 0)
		MakeAnswer(MyStr, "Not a valid equation. Its not a quadratic equation");
	else
		if(a == 0 && b != 0)
		{
			x1 = -(c / b);
			MakeAnswer(MyStr, x1);
		}
		else
		{
			det = b * b - 4 * a * c;
			if (det >= 0)
			{
				if(det == 0)
				{
					x1 = -(b / (2 * a));
					MakeAnswer(MyStr, x1);
				}
				else //det > 0
				{
					x1 = (-b + sqrt(det)) / (2 * a);
					x2 = (-b - sqrt(det)) / (2 * a);
					MakeAnswer(MyStr, x1, x2);
				}
			}
			else //det < 0
				MakeAnswer(MyStr, "Not a real root");
		}

	LOGI("End GetData");

	return env->NewStringUTF(MyStr.c_str());
}
