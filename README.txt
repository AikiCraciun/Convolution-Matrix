The Convolution Matrix Command Line Interface program features:
George-Alexandru Craciun

#################################
#     Image Filtering System    #
#################################
(1) Enter Image Name
(2) Select a Filter
(3) Quit
Select an option [1-3]

1. Image name should be given without the "png" extension (i.e bridge-gs, bridge-rgb, gmit-rgb, gmit-gs etc.).
2. The images should be placed inside "src" directory in order for the program to be able to read the images without any IOException to be thrown. 
3. Convolution Fiter has to be chosen by pressing any option between 1 to 11.
4. The output images (convoluted images) will be saved in the same "src" directory with the naming pattern as follows <imageName>[<kernelType>].png
5. The program contains the following filters: 

#################################
#  Select a Convolution Kernel  #
#################################
(1)  IDENTITY
(2)  EDGE_DETECTION1
(3)  EDGE_DETECTION2
(4)  LAPLACIAN
(5)  SHARPEN
(6)  VERTICAL_LINES
(7)  HORIZONTAL_LINES
(8)  DIAGONAL_45_LINES
(9)  SOBEL_HORIZONTAL
(10) SOBEL_VERTICAL
(11) BOX_BLUR
Select an option [1-11]