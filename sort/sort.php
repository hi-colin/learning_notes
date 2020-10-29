<?php

// 冒泡排序
function bubble_sort($arr)
{
    for ($i = 0, $len = count($arr); $i < $len - 1; $i++) {
        for ($j = 0; $j < $len - $i - 1; $j++) {
            if ($arr[$j] > $arr[$j + 1]) {
                $tmp = $arr[$j];
                $arr[$j] = $arr[$j + 1];
                $arr[$j + 1] = $tmp;
            }
        }
    }
    return $arr;
}


// 快速排序
function quick_sort($arr)
{
    $len = count($arr);
    if ($len <= 1) {
        return $arr;
    }

    $base_num = $arr[0];
    $left_arr = [];
    $right_arr = [];

    for($i = 1; $i < count($arr); $i++) {
        if ($arr[$i] < $base_num) {
            $left_arr[] = $arr[$i];
        } else {
            $right_arr[] = $arr[$i];
        }
    }

    $left_arr = quick_sort($left_arr);
    $right_arr = quick_sort($right_arr);

    return array_merge($left_arr, array($base_num), $right_arr);
}


// 选择排序
function select_sort($arr)
{
    $len = count($arr);

    for($i = 0; $i < $len -1; $i++) {
        $minIndex = $i;

        for($j = $i + 1; $j < $len; $j++) {
            if ($arr[$j] < $arr[$minIndex]) {
                $minIndex = $j;
            }
        }

        $tmp = $arr[$i];
        $arr[$i] = $arr[$minIndex];
        $arr[$minIndex] = $tmp;
    }
}


// 插入排序
function insert_sort($arr)
{
    $len = count($arr);

    for($i = 1; $i < $len; $i++) {
        $preIndex = $i - 1;
        $current = $arr[$i];

        while ($preIndex >= 0 && $arr[$preIndex] > $current) {
            $arr[$preIndex + 1] = $arr[$preIndex];
            $preIndex--;
        }

        $arr[$preIndex + 1] = $current;
    }
}

















