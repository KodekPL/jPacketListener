package jcraft.pl;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.server.v1_8_R1.*;

public enum PacketType {

    OUT_KEEP_ALIVE(PacketPlayOutKeepAlive.class),
    OUT_LOGIN(PacketPlayOutLogin.class),
    OUT_CHAT(PacketPlayOutChat.class),
    OUT_UPDATE_TIME(PacketPlayOutUpdateTime.class),
    OUT_ENTITY_EQUIPMENT(PacketPlayOutEntityEquipment.class),
    OUT_SPAWN_POSITION(PacketPlayOutSpawnPosition.class),
    OUT_UPDATE_HEALTH(PacketPlayOutUpdateHealth.class),
    OUT_RESPAWN(PacketPlayOutRespawn.class),
    OUT_POSITION(PacketPlayOutPosition.class),
    OUT_HELD_ITEM_SLOT(PacketPlayOutHeldItemSlot.class),
    OUT_BED(PacketPlayOutBed.class),
    OUT_ANIMATION(PacketPlayOutAnimation.class),
    OUT_NAMED_ENTITY_SPAWN(PacketPlayOutNamedEntitySpawn.class),
    OUT_COLLECT(PacketPlayOutCollect.class),
    OUT_SPAWN_ENTITY(PacketPlayOutSpawnEntity.class),
    OUT_SPAWN_ENTITY_LIVING(PacketPlayOutSpawnEntityLiving.class),
    OUT_SPAWN_ENTITY_PAINTING(PacketPlayOutSpawnEntityPainting.class),
    OUT_SPAWN_ENTITY_EXPPERIENCE_ORB(PacketPlayOutSpawnEntityExperienceOrb.class),
    OUT_ENTITY_VELOCITY(PacketPlayOutEntityVelocity.class),
    OUT_ENTITY_DESTROY(PacketPlayOutEntityDestroy.class),
    OUT_ENTITY(PacketPlayOutEntity.class),
    OUT_REL_ENTITY_MOVE(PacketPlayOutRelEntityMove.class),
    OUT_ENTITY_LOOK(PacketPlayOutEntityLook.class),
    OUT_REL_ENTITY_MOVE_LOOK(PacketPlayOutRelEntityMoveLook.class),
    OUT_ENTITY_TELEPORT(PacketPlayOutEntityTeleport.class),
    OUT_ENTITY_HEAD_ROTATION(PacketPlayOutEntityHeadRotation.class),
    OUT_ENTITY_STATUS(PacketPlayOutEntityStatus.class),
    OUT_ATTACH_ENTITY(PacketPlayOutAttachEntity.class),
    OUT_ENTITY_METADATA(PacketPlayOutEntityMetadata.class),
    OUT_ENTITY_EFFECT(PacketPlayOutEntityEffect.class),
    OUT_REMOVE_ENTITY_EFFECT(PacketPlayOutRemoveEntityEffect.class),
    OUT_EXPERIENCE(PacketPlayOutExperience.class),
    OUT_UPDATE_ATTRIBUTES(PacketPlayOutUpdateAttributes.class),
    OUT_MAP_CHUNK(PacketPlayOutMapChunk.class),
    OUT_MULTI_BLOCK_CHANGE(PacketPlayOutMultiBlockChange.class),
    OUT_BLOCK_CHANGE(PacketPlayOutBlockChange.class),
    OUT_BLOCK_ACTION(PacketPlayOutBlockAction.class),
    OUT_BLOCK_BREAK_ANIMATION(PacketPlayOutBlockBreakAnimation.class),
    OUT_MAP_CHUNK_BULK(PacketPlayOutMapChunkBulk.class),
    OUT_EXPLOSION(PacketPlayOutExplosion.class),
    OUT_WORLD_EVENT(PacketPlayOutWorldEvent.class),
    OUT_NAMED_SOUND_EFFECT(PacketPlayOutNamedSoundEffect.class),
    OUT_WORLD_PARTICLES(PacketPlayOutWorldParticles.class),
    OUT_GAME_STATE_CHANGE(PacketPlayOutGameStateChange.class),
    OUT_SPAWN_ENTITY_WEATHER(PacketPlayOutSpawnEntityWeather.class),
    OUT_OPEN_WINDOW(PacketPlayOutOpenWindow.class),
    OUT_CLOSE_WINDOW(PacketPlayOutCloseWindow.class),
    OUT_SET_SLOT(PacketPlayOutSetSlot.class),
    OUT_WINDOW_ITEMS(PacketPlayOutWindowItems.class),
    OUT_WINDOW_DATA(PacketPlayOutWindowData.class),
    OUT_TRANSACTION(PacketPlayOutTransaction.class),
    OUT_UPDATE_SIGN(PacketPlayOutUpdateSign.class),
    OUT_MAP(PacketPlayOutMap.class),
    OUT_TILE_ENTITY_DATA(PacketPlayOutTileEntityData.class),
    OUT_OPEN_SIGN_EDITOR(PacketPlayOutOpenSignEditor.class),
    OUT_STATISTIC(PacketPlayOutStatistic.class),
    OUT_PLAYER_INFO(PacketPlayOutPlayerInfo.class),
    OUT_ABILITIES(PacketPlayOutAbilities.class),
    OUT_TAB_COMPLETE(PacketPlayOutTabComplete.class),
    OUT_SCOREBOARD_OBJECTIVE(PacketPlayOutScoreboardObjective.class),
    OUT_SCOREBOARD_SCORE(PacketPlayOutScoreboardScore.class),
    OUT_SCOREBOARD_DISPLAY_OBJECTIVE(PacketPlayOutScoreboardDisplayObjective.class),
    OUT_SCOREBOARD_TEAM(PacketPlayOutScoreboardTeam.class),
    OUT_CUSTOM_PAYLOAD(PacketPlayOutCustomPayload.class),
    OUT_KICK_DISCONNECT(PacketPlayOutKickDisconnect.class),
    OUT_SERVER_DIFFICULTY(PacketPlayOutServerDifficulty.class),
    OUT_COMBAT_EVENT(PacketPlayOutCombatEvent.class),
    OUT_CAMERA(PacketPlayOutCamera.class),
    OUT_WORLD_BORDER(PacketPlayOutWorldBorder.class),
    OUT_TITLE(PacketPlayOutTitle.class),
    OUT_SET_COMPRESSION(PacketPlayOutSetCompression.class),
    OUT_PLAYER_LIST_HEADER_FOOTER(PacketPlayOutPlayerListHeaderFooter.class),
    OUT_RESOURCE_PACK_SEND(PacketPlayOutResourcePackSend.class),
    OUT_UPDATE_ENTITY_NBT(PacketPlayOutUpdateEntityNBT.class),

    IN_KEEP_ALIVE(PacketPlayInKeepAlive.class),
    IN_CHAT(PacketPlayInChat.class),
    IN_USE_ENTITY(PacketPlayInUseEntity.class),
    IN_FLYING(PacketPlayInFlying.class),
    IN_POSITION(PacketPlayInPosition.class),
    IN_LOOK(PacketPlayInLook.class),
    IN_POSITION_LOOK(PacketPlayInPositionLook.class),
    IN_BLOCK_DIG(PacketPlayInBlockDig.class),
    IN_BLOCK_PLACE(PacketPlayInBlockPlace.class),
    IN_HELD_ITEM_SLOT(PacketPlayInHeldItemSlot.class),
    IN_ARM_ANIMATION(PacketPlayInArmAnimation.class),
    IN_ENTITY_ACTION(PacketPlayInEntityAction.class),
    IN_STEER_VEHICLE(PacketPlayInSteerVehicle.class),
    IN_CLOSE_WINDOW(PacketPlayInCloseWindow.class),
    IN_WINDOW_CLICK(PacketPlayInWindowClick.class),
    IN_TRANSACTION(PacketPlayInTransaction.class),
    IN_SET_CREATIVE_SLOT(PacketPlayInSetCreativeSlot.class),
    IN_ENCHANT_ITEM(PacketPlayInEnchantItem.class),
    IN_UPDATE_SIGN(PacketPlayInUpdateSign.class),
    IN_ABILITIES(PacketPlayInAbilities.class),
    IN_TAB_COMPLETE(PacketPlayInTabComplete.class),
    IN_SETTINGS(PacketPlayInSettings.class),
    IN_CLIENT_COMMAND(PacketPlayInClientCommand.class),
    IN_CUSTOM_PAYLOAD(PacketPlayInCustomPayload.class),
    IN_SPECTATE(PacketPlayInSpectate.class),
    IN_RESOURCE_PACK_STATUS(PacketPlayInResourcePackStatus.class);

    private static final Map<Class<?>, PacketType> typeByClass = new HashMap<Class<?>, PacketType>();

    private final Class<?> packetClass;

    PacketType(Class<?> packetClass) {
        this.packetClass = packetClass;
    }

    public Class<?> getPacketClass() {
        return this.packetClass;
    }

    public static PacketType getTypeByClass(Class<?> clazz) {
        return typeByClass.get(clazz);
    }

    static {
        for (PacketType type : values()) {
            typeByClass.put(type.getPacketClass(), type);
        }
    }

}
