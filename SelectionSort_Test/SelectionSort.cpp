/*
 * SelectionSort.cpp
 *
 *  Created on: Jan 8, 2019
 *      Author: durant
 */

#include<iostream>
using namespace std;

void Selection_Sort(int A[], int n) {

	for (int i = 0; i < n - 1; i++) {
		int min = i;
		for (int j = i; j < n; j++) {
			if (A[j] < A[min]) {
				min = j;
			}
		}
		int temp = A[min];
		A[min] = A[i];
		A[i] = temp;

	}

}

int main() {
	int A[] = { 1, 9, 10, 4, 7, 3, 2 };
	Selection_Sort(A, 7);

	cout << "Elements in A after SS." << endl;
	for (int i = 0; i < 7; i++) {
		cout << A[i] << endl;
	}

	return 0;
}

