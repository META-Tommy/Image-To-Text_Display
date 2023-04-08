__command() -> build();
create(xx,yy,zz,scale) -> (
    read = synchronize(read_file('Text_Display_Data', 'shared_text'));

    loop(4,
            run('execute positioned '+(xx+floor(_/2)*(0.03*scale)+0.00000001)+' '+(yy+_%2*(0.075*scale)++0.00000001)+' '+(zz+0.00000001)+' summon minecraft:text_display run data merge entity @s {text:\''+read:0+'\',interpolation_start:-1,background:0,interpolation_duration:0,transformation:{scale:['+scale*1.2+'f,'+scale+'f,'+scale+'f]},line_width:3000000}');
    );
);