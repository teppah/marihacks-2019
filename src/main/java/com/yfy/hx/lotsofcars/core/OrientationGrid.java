// package com.yfy.hx.lotsofcars.core;

// import lombok.extern.slf4j.Slf4j;
// import org.springframework.stereotype.Component;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Random;

// @Slf4j
// public class OrientationGrid {

//     public static int gridHeight;
//     public static int gridWidth;

//     public OrientationGrid(int gHeight, int gWidth){

//         gridHeight = gHeight;   // 20
//         gridWidth = gWidth;     // 40

//     }

//     public String[][] orientation_grid = new Stirng[gridWidth][gridHeight];


//     public void print() {
//         for (int i = 0; i < gridHeight; i++) {
//             for (int j = 0; j < gridWidth; j++) {
//                 System.out.print(orientation_grid[j][i] + " ");
//             }
//             System.out.println();
//         }
//     }

//     public String[][] return_orientation_grid_complete(int block_size){
//         for (int i = 0; i < gridHeight; i++) {
//             for (int j = 0; j < gridWidth; j++){
//                 orientation_grid[j][i] = return_road_orientation(j, i, block_size);
//             }
//         }

//         return orientation_grid;
//     }

//     public static String return_road_orientation(int x, int y, int block_size){
//         /** Function returns road orientation based on x and y coordinates
//         */

//         // based on a 5x5 block system
//         if((x%(block_size*2))==0 && (y%block_size)!=0){
//             return "down";
//         }

//         else if((x%(block_size*2))==5 && (y%(block_size))!=0){
//             return "up";
//         }

//         else if((x%(block_size))!=0 && (y%(block_size*2))==0){
//             return "left";
//         }

//         else if((x%(block_size))!=0 && (y%(block_size*2))==5){
//             return "right";
//         }

//         else if((x%block_size)==0 && (y%block_size)==0){
//             return "intersection";
//         }

//         else{
//             return "building";
//         }

//     }


// }
