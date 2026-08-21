class Processo:
    def __init__(self, id: int , descricao: str):
        self.id = id
        self.descricao = descricao
        
        
    def get_id(self) -> int:  
        return self.id
    
    def set_id(self, id: int ):
        self.id = id
        
    def get_descricao(self) -> str:
        return self.descricao
    
    def set_descricao(self, descricao: str):
        self.descricao = descricao
        
    def __str__(self):
        return f"Processo [id={self.id}, descricao={self.descricao}]"
    
    def __eq__(self, outro):
        if not isinstance(outro, Processo):
            return False
        return self.id == outro.id
    
    def __hash__(self):
           return hash(self.id)
       
    def __lt__(self, outro):
        if outro is None:
            return False #objeto nao eh menor 
        
        if not isinstance(outro, Processo):
            return NotImplemented
        
        return self.id < outro.id