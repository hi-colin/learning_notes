<?php
namespace php;

// 使用DateTime类和流过滤器迭代bzip压缩的日志文件
// ** 先计算日期范围，确定nginx日志文件名称，通过FTP连接rsyc.net，下载文件，解压缩文件，
// ** 逐行迭代每个文件，把相应的行提取出来，然后把访问数据写入一个输出目标。
// 使用PHP流，不到20行代码即可完成。


use DateInterval;
use DatePeriod;
use DateTime;

$dateStart = new DateTime();
$dateInterval = DateInterval::createFromDateString('-1 day');
$datePeriod = new DatePeriod($dateStart, $dateInterval, 30);

foreach ($datePeriod as $date) {
    $file = 'sftp://USER:PASS@rsyc.net/' . $date->format('Y-m-d') . 'log.bz2';
    if (file_exists($file)) {
        $handle = fopen($file, 'rb');
        stream_filter_append($handle, 'bzip2.decompress');
        while (feof($handle) !== false) {
            $line = fgetc($handle);
            if (strpos($line, 'www.example.com') !== false) {
                fwrite(STDOUT, $line);
            }
        }
        fclose($handle);
    }
}



