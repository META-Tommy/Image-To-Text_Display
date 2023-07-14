__command() -> build();
create(xx,yy,zz,scale) -> (
    read = synchronize(read_file('Text_Display_Data', 'shared_text'));

    loop(4,
            run('execute positioned '+(xx)+' '+(yy)+' '+(zz)+' summon minecraft:text_display run data merge entity @s {billboard:"vertical",text:\''+read:0+'\',interpolation_start:-1,background:0,interpolation_duration:0,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:['+(floor(_/2)*(0.03*scale))+'f,'+(_%2*(0.075*scale))+'f,0f],scale:['+scale*1.2+'f,'+scale+'f,'+scale+'f]},line_width:3000000}');
    );
);