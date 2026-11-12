from dataclasses import dataclass

@dataclass(eq=False)
class Sessao:
    numero: str
    dadosSessao: str
    
    
    def __hash__(self) -> int:
        return hash(self.numero)
    
    
    def __eq__(self, other: object) -> bool:
        if self is other:
            return True
        if not isinstance(other, Sessao):
            return False
        return self.numero == other.numero
    
    def __str__(self):
        return(f" Numero: {self.numero} - + Dados de Sessão: {self.dadosSessao}")