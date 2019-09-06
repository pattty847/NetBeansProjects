import numpy
from matplotlib import pyplot as plt


def compute_error(b, m, points):
    error = 0
    for i in range(0, len(points)):
        x = points[i, 0]
        y = points[i, 1]
        error += (y - (m * x + b)) ** 2
    return error / float(len(points))


def step_grad(cur_b, cur_m, points, learn_rate):
    grad_b = 0
    grad_m = 0
    N = float(len(points))
    for i in range(0, len(points)):
        x = points[i, 0]
        y = points[i, 1]
        grad_b += - (2/N) * (y - ((cur_m * x) + cur_b))
        grad_m += - (2/N) * x * (y - ((cur_m * x) + cur_b))
    new_b = cur_b - (learn_rate * grad_b)
    new_m = cur_m - (learn_rate * cur_m)
    # print(new_b, new_m)
    return [new_b, new_m]


def grad_desc(points, b_init, m_init, iterations, learn_rate):
    b = b_init
    m = m_init
    for i in range(iterations):
        b, m = step_grad(b, m, array(points), learn_rate)
        print(i, " B: ", b, "M:", m)
    return [b, m]


def run():
    points = numpy.genfromtxt("data.csv", delimiter=",")
    learn_rate = 0.00001
    b_init = 0
    m_init = 0
    iterations = 1000
    b, m = grad_desc(points, b_init, m_init, iterations, learn_rate)
    
    for k in range(len(points)):
        plt.title("Matplotlib demo") 
        plt.xlabel("x axis caption") 
        plt.ylabel("y axis caption") 
        plt.plot(points,"ob")
        plt.plot(b, m)
        plt.show() 

    print("B: ", b, "M:", m)
if __name__ == '__main__':
    run()
