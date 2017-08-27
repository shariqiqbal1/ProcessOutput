#!/bin/ksh
for (( i=20; i>0; i--)); do
  sleep 1 &
  echo " hello "
  wait
done