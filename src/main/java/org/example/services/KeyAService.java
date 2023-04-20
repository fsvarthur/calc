package org.example.services;

import org.example.models.KeyAnalyzers;

import java.util.List;

public interface KeyAService {
    List<KeyAnalyzers> getAllKeysAnalyzers();
    void updateKeyAnalyzer(KeyAnalyzers key, Long Id);
    void deleteKeyAnalyzer(Long id);
    void createKeyAnalyzer(KeyAnalyzers key);
    KeyAnalyzers getKeyAnalyzerById(Long Id);
}
