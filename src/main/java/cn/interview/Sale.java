package cn.interview;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author nizy
 * @date 2022/1/8 1:15 下午
 */
public class Sale {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

    public static void main(String[] args) throws Exception {
        TreeSet<Item> buySet = new TreeSet<>((o1, o2) -> o1.getDate().compareTo(o2.date));
        TreeSet<Item> saleItems = new TreeSet<>((o1, o2) -> o1.getDate().compareTo(o2.date));
        Item buyItem1 = new Item(1000, 1.5, simpleDateFormat.parse("2021-01-01"));
        Item buyItem2 = new Item(1000, 2.1, simpleDateFormat.parse("2021-01-05"));
        Item buyItem3 = new Item(1000, 1.7, simpleDateFormat.parse("2021-01-07"));
        Item buyItem4 = new Item(1000, 1.1, simpleDateFormat.parse("2021-01-09"));
        buySet.add(buyItem1);
        buySet.add(buyItem2);
        buySet.add(buyItem3);
        buySet.add(buyItem4);
        Item saleItem1 = new Item(2500, 2.0, simpleDateFormat.parse("2021-01-08"));
        saleItems.add(saleItem1);
        List<Item> buyItems = new ArrayList<>(buySet);
        saleItems.forEach(saleItem -> {
            int start = 0;
            int end = buyItems.size() - 1;
            while (start <= end) {
                int mid = start + ((end - start) >> 1);
                Item buyItem = buyItems.get(mid);
                int compareResult = saleItem.getDate().compareTo(buyItem.getDate());
                if (compareResult == 0) {
                    end = mid - 1;
                } else if (compareResult > 0) {
                    start = mid + 1;
                } else if (compareResult < 0) {
                    end = mid - 1;
                }
            }
            if (end == -1) {
                return;
            }
            for (int i = 0; i <= end; i++) {
                Item buyItem = buyItems.get(i);
                   if (saleItem.getNum() > 0) {
                       int buyNum = buyItem.num;
                       int saleNum = saleItem.num;
                       saleItem.setNum(Math.max(0, saleNum - buyNum));
                       buyItem.setNum(Math.max(0, buyNum - saleNum));
                   }
            }
        });
        double sum = buyItems.stream().mapToDouble(buyItem -> buyItem.getNum() * buyItem.price).sum();
        System.out.println(sum);

    }

    public static class Item {
        private int num;
        private double price;
        private Date date;

        public Item(int num, double price, Date date) {
            this.num = num;
            this.price = price;
            this.date = date;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }

}
