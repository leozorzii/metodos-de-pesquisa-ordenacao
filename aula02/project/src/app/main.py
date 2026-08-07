"""ponto de entrada da aplicacao.

Execute a partir da pasta aula02 com:
    python -m project.src.app.main
"""

from project.src.controller.list_controller import Controller


def main() -> None:
    """instancia o controller e dispara o processamento das rotinas."""
    controller = Controller()
    controller.executar_processamento()


if __name__ == "__main__":
    main()
