package com.sujeetkumar.catapp.migrations;

import java.util.List;

public interface Migration {
    int getVersion();
    List<String> getStatements();
}
