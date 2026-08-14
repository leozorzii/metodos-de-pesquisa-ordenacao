"""exemplo minimo de como medir o tempo de execucao de uma rotina."""

import time

tempo_inicio = time.perf_counter()
# rotina a ser medida
tempo_fim = time.perf_counter()
print("Tempo da rotina 1:", (tempo_fim - tempo_inicio), "s")
