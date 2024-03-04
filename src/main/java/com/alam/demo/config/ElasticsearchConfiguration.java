package com.alam.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
//import org.springframework.data.elasticsearch.config.ElasticsearchConfigurationSupport;
//import org.springframework.data.elasticsearch.core.convert.ElasticsearchCustomConversions;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Optional;

//@Configuration
//@EnableTransactionManagement
//@EnableElasticsearchRepositories("com.alam.demo.repository.search")
public class ElasticsearchConfiguration /*extends ElasticsearchConfigurationSupport*/ {
//    @Bean
//    @Override
//    public ElasticsearchCustomConversions elasticsearchCustomConversions() {
//        return new ElasticsearchCustomConversions(
//            Arrays.asList(
//                new ZonedDateTimeWritingConverter(),
//                new ZonedDateTimeReadingConverter(),
//                new InstantWritingConverter(),
//                new InstantReadingConverter(),
//                new LocalDateWritingConverter(),
//                new LocalDateReadingConverter()
//            )
//        );
//    }
//
//    @WritingConverter
//    static class ZonedDateTimeWritingConverter implements Converter<ZonedDateTime, String> {
//
//        @Override
//        public String convert(ZonedDateTime source) {
//            return Optional.ofNullable(source)
//                    .map(item -> item.toInstant().toString())
//                    .orElse(null);
//        }
//    }
//
//    @ReadingConverter
//    static class ZonedDateTimeReadingConverter implements Converter<String, ZonedDateTime> {
//
//        @Override
//        public ZonedDateTime convert(String source) {
//            return Optional.ofNullable(source)
//                    .map(item -> Instant.parse(item).atZone(ZoneId.systemDefault()))
//                    .orElse(null);
//        }
//    }
//
//    @WritingConverter
//    static class InstantWritingConverter implements Converter<Instant, String> {
//
//        @Override
//        public String convert(Instant source) {
//            return Optional.ofNullable(source)
//                    .map(Instant::toString)
//                    .orElse(null);
//        }
//    }
//
//    @ReadingConverter
//    static class InstantReadingConverter implements Converter<String, Instant> {
//
//        @Override
//        public Instant convert(String source) {
//            return Optional.ofNullable(source)
//                    .map(Instant::parse)
//                    .orElse(null);
//        }
//    }
//
//    @WritingConverter
//    static class LocalDateWritingConverter implements Converter<LocalDate, String> {
//
//        @Override
//        public String convert(LocalDate source) {
//            return Optional.ofNullable(source)
//                    .map(LocalDate::toString)
//                    .orElse(null);
//        }
//    }
//
//    @ReadingConverter
//    static class LocalDateReadingConverter implements Converter<String, LocalDate> {
//
//        @Override
//        public LocalDate convert(String source) {
//            return Optional.ofNullable(source)
//                    .map(LocalDate::parse)
//                    .orElse(null);
//        }
//    }
}
