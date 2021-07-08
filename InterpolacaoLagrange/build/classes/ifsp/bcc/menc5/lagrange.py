import matplotlib.pyplot as plt
import numpy as np
import sys
#coding: utf-8

def main(argv):
	qtdValores, parametros, x, y = int(sys.argv[1]), [], [], []

	for param in sys.argv[2:]: # Transformar parametros para float
		parametros.append(float(param))

	for copy in parametros[:qtdValores]: # Copiar parametros equivalentes a X passados no CMD e adicioná-los ao vetor X
		x.append(copy)
	print(f'Valores de X: {x}')

	for copy in parametros[len(x):(2*qtdValores)]: # Copiar parametros equivalentes a Y passados no CMD e adicioná-los ao vetor Y
		y.append(copy)
	print(f'Valores de Y: {y}')

	grafico(qtdValores, x, y)


def Px(numVars, x, y, pontoXnovo):
	phi=float(0)
	for i in range(numVars):
		phi += (y[i]*Lk(i, numVars, x, pontoXnovo))
	return phi

def Lk(count, numVars, x, pontoXnovo):
	l=float(1)
	for k in range(numVars):
		if (k!=count):
			l *= ((pontoXnovo-x[k])/(x[count]-x[k]))
	return l

def grafico(numVars, x, y):
	intervaloX = []
	intervaloX = np.linspace(x[0], x[len(x)-1])
	phi=[]
	for i in range(len(intervaloX)):
		phi.append(Px(numVars, x, y, intervaloX[i]))
	plt.plot(intervaloX, phi, label='P(x)')
	plt.plot(x, y, 'o', label='(x,y)')
	plt.xlabel("x")
	plt.ylabel("y")
	plt.legend()
	plt.show()

if __name__ == '__main__':
	main(sys.argv[1:])