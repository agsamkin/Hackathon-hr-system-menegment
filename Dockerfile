FROM gradle:7.6-jdk17

WORKDIR /hackathon

COPY ./ .

RUN gradle assembleFrontend
RUN gradle installDist

CMD ./build/install/hackathon/bin/hackathon