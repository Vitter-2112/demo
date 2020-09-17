package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Item {


        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;
        private String name;
        private String size;

        protected Item() {}

        public Item(String name, String size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public String toString() {
            return String.format(
                    "Item[id=%d, name='%s', size='%s']",
                    id, name, size);
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSize() {
            return size;
        }
    }

