use db_do_ani;

select *
from chuyen_bay cb
join tuyen_bay tb on cb.id_tuyenbay = tb.id
join loai_tuyen_bay ltb on tb.id_loai_tuyen_bay = ltb.id
where ltb.ten_loai_tuyen_bay="Trong nước" and (cb.tinh_trang_chuyen_bay='Mất tín hiệu' or cb.ngay_di ='2021-07-28');