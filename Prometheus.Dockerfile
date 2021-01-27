FROM prom/prometheus
COPY --chown=nobody:nobody conf/prometheus/prometheus.yml /etc/prometheus/
