package util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Sessao;

public class Utils {

    /**
     * Lê o arquivo (uma sessão por linha, no formato numero;{json}) e devolve um
     * mapa novo com chave = número do celular.
     *
     * @return o mapa carregado, ou null se o arquivo não pôde ser lido
     */
    public static Map<String, Sessao> carregarArquivoEmHashMap(String nomeArquivo) {
        Map<String, Sessao> sessoes = new HashMap<>();
        try {
            Path caminho = Paths.get(nomeArquivo);

            //  le todas as linhas do arquivo de uma vez so
            List<String> linhas = Files.readAllLines(caminho, StandardCharsets.UTF_8);

            for (String linha : linhas) {
                if (!linha.trim().isEmpty()) {
                    // limite 2: corta só no primeiro ";", o resto (JSON) fica inteiro
                    String[] dadosLinha = linha.split(";", 2);

                    if (dadosLinha.length >= 2) {
                        Sessao sessao = criarSessao(dadosLinha[0].trim(), dadosLinha[1].trim());
                        sessoes.put(sessao.getNumero(), sessao);
                    }
                }
            }

            return sessoes;
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
            return null;
        }
    }

    // monta a Sessao lendo cada campo do JSON uma unica vez, na carga do arquivo
    private static Sessao criarSessao(String numero, String json) {
        Sessao sessao = new Sessao();
        sessao.setNumero(numero);
        sessao.setSessionID(extrairCampo(json, "session_id"));
        sessao.setImsi(extrairCampo(json, "imsi"));
        sessao.setImei(extrairCampo(json, "imei"));
        sessao.setMcc(extrairCampo(json, "mcc"));
        sessao.setMnc(extrairCampo(json, "mnc"));
        sessao.setCellID(extrairCampo(json, "cell_id"));
        sessao.setLac(extrairCampo(json, "lac"));
        sessao.setBearer(extrairCampo(json, "bearer"));
        sessao.setStartTime(extrairCampo(json, "start_time"));
        sessao.setEndTime(extrairCampo(json, "end_time"));
        sessao.setDurationS(extrairCampo(json, "duration_s"));
        sessao.setIpAddr(extrairCampo(json, "ip_addr"));
        sessao.setSipCallID(extrairCampo(json, "sip_call_id"));
        sessao.setCodec(extrairCampo(json, "codec"));
        sessao.setBytesUp(extrairCampo(json, "bytes_up"));
        sessao.setBytesDown(extrairCampo(json, "bytes_down"));
        sessao.setLat(extrairCampo(json, "lat"));
        sessao.setLon(extrairCampo(json, "lon"));
        sessao.setEncryption(extrairCampo(json, "encryption"));
        return sessao;
    }

    // esse metodo serve para extrair o valor exato de um campo especifico de texto
    // que esta em formato JSON, JSON = texto completo, campo é a chave que queremos ler
    //Pattern busca compilada - traduz a estrutura para o java
    // Matcher - motor que vai varrer o json procurando pelo PADRAO
    public static String extrairCampo(String json, String campo) {
        //Pattern.quote garante que caracteres especiais nao quebrem a busca
        Pattern padrao = Pattern.compile("\"" + Pattern.quote(campo) + "\"\\s*:\\s*(\"([^\"]*)\"|[^,}]+)");
        Matcher m = padrao.matcher(json);
        //percorre o texto ate achar a primeira ocorrencia daquele padrao
        if (!m.find()) {
            return "";
        }
        //recupera o trecho de onde foi achado o padrao
        return m.group(2) != null ? m.group(2) : m.group(1).trim();
    }
    
    
    private static final DateTimeFormatter FORMATO =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static String formatarDataHora(String iso) {
        if (iso == null || iso.isBlank()) {
            return "";
        }
        try {
            return Instant.parse(iso)
                    .atZone(ZoneId.of("America/Sao_Paulo"))   // horário de Brasília
                    .format(FORMATO);
        } catch (java.time.format.DateTimeParseException e) {
            return iso; // se vier fora do padrão, devolve como está
        }
    }
}