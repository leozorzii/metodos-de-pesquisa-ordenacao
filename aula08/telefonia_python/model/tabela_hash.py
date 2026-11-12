from dataclasses import dataclass
from model.sessao import Sessao

class TabelaHash:
    def __init__(self):
        self.sessoes : dict[str, Sessao] = {}