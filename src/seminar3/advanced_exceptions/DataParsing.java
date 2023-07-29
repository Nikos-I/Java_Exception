package seminar3.advanced_exceptions;

import java.util.HashMap;

public class DataParsing {

    public HashMap<String, Object> parsingInputData() {
        String[] data = DataInput.inputStr();
        HashMap<String, Object> dataDict = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String d : data) {
            if (d.length() == 1) {                      // Ищем пол
                if (d.equals("f") || d.equals("m")) {
                    dataDict.put("sex", d);
                } else{
                    try {
                        throw new SexException();
                    } catch (SexException e) {
                        e.sexException(d);
                    }
                }
            } else if (d.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {     // Ищем дату
                String[] arrayDate = d.split("\\.");
                boolean flag = true;
                if (Integer.parseInt(arrayDate[0]) <= 0 ||
                        Integer.parseInt(arrayDate[0]) > 31 || Integer.parseInt(arrayDate[1]) < 0 ||
                        Integer.parseInt(arrayDate[1]) > 12 || Integer.parseInt(arrayDate[2]) < 0 ||
                        Integer.parseInt(arrayDate[2]) >= 2023) {
                    try {
                        throw new DateException();
                    } catch (DateException e) {
                        e.dataException(d);
                    }
                } else {
                    if (Integer.parseInt(arrayDate[2]) % 4 == 0) {      // Ищем телефон
                        if (Integer.parseInt(arrayDate[1]) == 1 ||
                                Integer.parseInt(arrayDate[1]) == 3 ||
                                Integer.parseInt(arrayDate[1]) == 5 ||
                                Integer.parseInt(arrayDate[1]) == 7 ||
                                Integer.parseInt(arrayDate[1]) == 9 ||
                                Integer.parseInt(arrayDate[1]) == 10 ||
                                Integer.parseInt(arrayDate[1]) == 12) {
                            if (Integer.parseInt(arrayDate[0]) < 32) {
                                flag = false;
                            }
                        } else if (Integer.parseInt(arrayDate[1]) == 2) {
                            if (Integer.parseInt(arrayDate[0]) < 30) {
                                flag = false;
                            }
                        } else if (Integer.parseInt(arrayDate[1]) == 4 ||
                                Integer.parseInt(arrayDate[1]) == 6 ||
                                Integer.parseInt(arrayDate[1]) == 8 ||
                                Integer.parseInt(arrayDate[1]) == 11) {
                            if (Integer.parseInt(arrayDate[0]) < 31) {
                                flag = false;
                            }
                        }
                    } else {
                        if (Integer.parseInt(arrayDate[1]) == 1 ||
                                Integer.parseInt(arrayDate[1]) == 3 ||
                                Integer.parseInt(arrayDate[1]) == 5 ||
                                Integer.parseInt(arrayDate[1]) == 7 ||
                                Integer.parseInt(arrayDate[1]) == 9 ||
                                Integer.parseInt(arrayDate[1]) == 10 ||
                                Integer.parseInt(arrayDate[1]) == 12) {
                            if (Integer.parseInt(arrayDate[0]) < 32) {
                                flag = false;
                            }
                        } else if (Integer.parseInt(arrayDate[2]) == 2) {
                            if (Integer.parseInt(arrayDate[0]) < 29) {
                                flag = false;
                            }
                        } else if (Integer.parseInt(arrayDate[1]) == 4 ||
                                Integer.parseInt(arrayDate[1]) == 6 ||
                                Integer.parseInt(arrayDate[1]) == 8 ||
                                Integer.parseInt(arrayDate[1]) == 11) {
                            if (Integer.parseInt(arrayDate[0]) < 31) {
                                flag = false;
                            }
                        }

                    }
                    if (!flag) {
                        dataDict.put("date", d);
                    } else try {
                        throw new DataException();
                    } catch (DataException e) {
                        e.dataException(d);
                    }
                }

            } else if (d.matches("[0-9]+")) {
                dataDict.put("tel", d);
            } else if (d.matches("[A-Za-z]+")) {
                sb.append(d + " ");
            } else {
                try {
                    throw new DataException();
                } catch (DataException e) {
                    e.dataException(d);
                }
            }
        }
        String[] fullName = String.valueOf(sb).split(" ");      // Собираем ФИО
        if (fullName.length == 3) {
            dataDict.put("lastName", fullName[0]);
            dataDict.put("firstName", fullName[1]);
            dataDict.put("patronymic", fullName[2]);
        }
        return dataDict;
    }

}
