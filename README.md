# The Convolution Matrix

## Intructions how to run the program
1. The __src__ directory should be downloaded locally. 
1. From the __src/ie/gmit/dip__ directory, run the following command line instruction 
```
javac *.java
java Runner
```
3. Once __java Runner__ command is run form the CLI, the following options should be rendered on screen.

## _Main Features - Image Filtering System_
* (1) Enter Image Name
* (2) Select a Filter
* (3) Quit
* Select an option [1-3]

## Intructions how to use the CLI program
1. Image name should be given without the "png" extension (i.e bridge-gs, bridge-rgb, gmit-rgb, gmit-gs etc.).
1. The images should be placed inside "src" directory in order for the program to be able to read the images without any IOException to be thrown. 
1. Convolution Fiter has to be chosen by pressing any option between 1 to 11.
1. The output images (convoluted images) will be saved in the same "src" directory with the naming pattern as follows [imageName].[kernelType].png
1. The program contains the filters shown below: 

##  Select a Convolution Kernel
* (1)  IDENTITY
* (2)  EDGE_DETECTION1
* (3)  EDGE_DETECTION2
* (4)  LAPLACIAN
* (5)  SHARPEN
* (6)  VERTICAL_LINES
* (7)  HORIZONTAL_LINES
* (8)  DIAGONAL_45_LINES
* (9)  SOBEL_HORIZONTAL
* (10) SOBEL_VERTICAL
* (11) BOX_BLUR
* Select an option [1-11]


## License
GNU General Public License v3.0 

**Free Software, Happy days!**


