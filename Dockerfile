FROM gradle:7.6-jdk17

WORKDIR /hackaton

COPY ./ .

RUN gradle assembleFrontend
RUN gradle installDist

CMD ./build/install/hackaton/bin/hackaton