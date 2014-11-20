#!/bin/bash

############################################################################################
# each dataset is copied in a way to have exactly 20 blocks, thus fully utilize 20 wrokers #
############################################################################################



echo "--- Copy Citation_FCF ---"
#./client.sh dfs -copyFromLocal /var/scratch/yongguo/input/filtered/Citation_FCF /local/hadoop.tmp.yongguo
./client.sh dfs -D dfs.block.size=15769600 -copyFromLocal /var/scratch/yongguo/sc_dataset/Citation_FCF /local/hadoop.tmp.yongguo/Citation_FCF
mkdir -p /var/scratch/yongguo/output/giraph_bfs/vs2_output_Citation_FCF

for i in 1 2 3 4 5 #6 7 8 9 10
do
    echo "--- Run $i Stats for Citation_FCF ---"
    ./client.sh jar /home/yongguo/exeLibs/giraphJobs.jar org.test.giraph.BFSJob -D mapred.child.java.opts="-Xms10240m -Xmx10240m" directed /local/hadoop.tmp.yongguo/Citation_FCF /local/hadoop.tmp.yongguo/vs2_output_$i\_Citation_FCF 40 4949326 
    echo "--- Copy output ---"
    ./client.sh dfs -copyToLocal /local/hadoop.tmp.yongguo/vs2_output_$i\_Citation_FCF/benchmark.txt /var/scratch/yongguo/output/giraph_bfs/vs2_output_Citation_FCF/benchmark_$i
    echo "--- Clear dfs ---"
    ./client.sh dfs -rmr /local/hadoop.tmp.yongguo/vs2_output_$i\_Citation_FCF
    rm -rf /var/scratch/${USER}/hadoop_giraph_logs/userlogs
done

./client.sh dfs -rm /local/hadoop.tmp.yongguo/Citation_FCF
echo "--- Citation_FCF DONE ---"

# --------------------------------------------------------------------------------------------
