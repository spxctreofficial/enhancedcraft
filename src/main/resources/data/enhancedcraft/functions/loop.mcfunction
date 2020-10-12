
# Raycast if water used
execute as @a[scores={portal_one=1..}] at @s rotated as @s anchored eyes positioned ^ ^ ^ run function enhancedcraft:portal1/cast

# Run cloud checks on raycast clouds if not cancelled
execute as @e[type=minecraft:area_effect_cloud,tag=p1_cloud] at @s run function enhancedcraft:portal1/cloud
execute as @e[tag=portal1] at @s run function enhancedcraft:portal1/portal1

