FROM grafana/grafana
COPY --chown=nobody:nobody conf/grafana/grafana.ini /etc/grafana/