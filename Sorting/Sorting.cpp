/*
 * Sorting.cpp
 * Frequently used sorting algorithms
 *
 *  Created on: Jan 7, 2019
 *      Author: durant
 */

#include<iostream>
using namespace std;

void SelectionSort(int A[], int n) {
	int min = 0;
	int temp = 0;

	for (int i = 0; i < n - 1; i++) {
		//int
		min = i;

		for (int j = i; j < n; j++) {
			if (A[j] < A[min])
				min = j;
		}

		//int
		temp = A[min];
		A[min] = A[i];
		A[i] = temp;

	}

}

void BubbleSort(int A[], int n) {

	for (int i = n; i > 0; i--) {

		for (int j = 0; j < i; j++) {
			if (A[j] > A[j + 1]) {
				int temp = A[j];
				A[j] = A[j + 1];
				A[j + 1] = temp;
			}
		}

	}

}

int main() {

	int A[] = { 1, 7, 2, 6, 3,4 };
	int n = sizeof(A) / sizeof(A[0]);
	for (int i = 0; i < n; i++) {
		cout << A[i] << endl;
	}

	//SelectionSort(A, n);
	BubbleSort(A, n);


	cout << "----------------" << n << endl;

	for (int i = 0; i < n; i++) {
		cout << A[i] << endl;
	}

	return 0;
}

