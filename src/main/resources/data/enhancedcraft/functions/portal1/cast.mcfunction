# AS AT Player who placed water

# Summon Area Effect cloud at player eyes
summon minecraft:area_effect_cloud ^ ^ ^ {Duration:120,Tags:["p1_cloud"]}

# Match player rotation
execute as @e[type=minecraft:area_effect_cloud,tag=p1_cloud] run tp @s ^ ^ ^ ~ ~

# Reset Scoreboard
scoreboard players reset @s portal_one