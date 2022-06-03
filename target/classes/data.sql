insert into product(code, name)
values ('TRAVELER', '여행자 보험');
insert into product(code, name)
values ('MOBILE', '휴대폰 보험');

insert into collateral(product_id, code, name, insurable_money, standard_money)
values (1, 'INJURY_PAY', '상해치료비', '1000000', '100');
insert into collateral(product_id, code, name, insurable_money, standard_money)
values (1, 'PLANE_DELAYED_ARRIVAL_PAY', '항공기 지연도착시 보상금', '500000', '100');

insert into collateral(product_id, code, name, insurable_money, standard_money)
values (2, 'PART_LOSS', '부분손실', '750000', '38');
insert into collateral(product_id, code, name, insurable_money, standard_money)
values (2, 'TOTAL_LOSS', '전체손실', '1570000', '40');