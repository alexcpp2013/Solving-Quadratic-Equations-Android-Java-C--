package test.example.solvingequation;

public class SolvingEquation {
	// �������� ������ �AndroidNDK� � �������� ����������, � ������� ����������� ������.
	// �������� ����� ������ �������� � ����� Android.mk.
	static {
		System.loadLibrary("SolvingEquation");
	}
	
	public static native String Solving(double a, double b, double c);

}
