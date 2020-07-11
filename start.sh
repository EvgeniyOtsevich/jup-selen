#!/bin/bash
cat ./selenoid/config/browsers.json | jq -r '..|.image?|strings' | xargs -I{} docker pull {}
docker-compose up