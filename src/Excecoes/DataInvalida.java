package Excecoes;

import java.time.LocalDate;

public class DataInvalida {
    public static boolean VerificaData(LocalDate dataInformada){
        return dataInformada < LocalDate.now();
    }
}
