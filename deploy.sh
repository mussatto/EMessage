#!/bin/bash
mvn clean -U install
appcfg.sh -A emessage-m update target/emessage-0.1-SNAPSHOT
